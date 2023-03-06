package com.sharepic.PostService.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import com.sharepic.PostService.Dto.*;
import com.sharepic.PostService.Entity.PostedContent;
import com.sharepic.PostService.Entity.User;
import com.sharepic.PostService.repository.PostServiceReposiotry;
import com.sharepic.PostService.repository.impl.PostServiceRepositoryImpl;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.sharepic.PostService.JpaRepository.*;
import com.sharepic.PostService.mapper.PostedContentMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import net.bytebuddy.utility.RandomString;

@Component
public class DataBucketUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataBucketUtil.class);
	
	@Value("${gcp.config.file}")
	private String gcpConfigFile;

	@Value("${gcp.project.id}")
	private String gcpProjectId;

	@Value("${gcp.bucket.id}")
	private String gcpBucketId;

	@Value("${file.upload-dir}")
	private String path;
	
	final String gcpConsoleURl = "gs://sharepic_files";
	
	@Autowired
	private Storage storage;
	
	@Autowired
	private PostServiceReposiotry postServiceJpaRepo;
	
	@Autowired
	private UserJpaRepository userJpaRepo;
	
	@Autowired
	private PostServiceJpaRepo postRepo;
	
	@Autowired
	private PostedContentMapper mapper;
	

	
	public String uploadFile(MultipartFile multipartFile, String name )  {
		try{

            LOGGER.debug("Start file uploading process on GCS");
           // byte[] fileData = FileUtils.readFileToByteArray(convertFile(multipartFile));
            
            User user = userJpaRepo.findByUserName(name);
    		if(user != null)
    		{
            
            StringBuffer sb = new StringBuffer();
            sb.append(gcpConsoleURl).append("/" + gcpBucketId);
           // sb.append("/");
            //sb.append(gcpBucketId);
            sb.append("/" +multipartFile.getOriginalFilename());
            byte[] fileData =multipartFile.getBytes();
            BlobId id =BlobId.of(gcpBucketId, multipartFile.getOriginalFilename());
            BlobInfo info = BlobInfo.newBuilder(id).build();
            File file = new File(path , multipartFile.getOriginalFilename());
            byte[] arr=Files.readAllBytes(Paths.get(file.toURI()));
    		storage.create(info, arr);
    		System.out.println(info.getMediaLink() + "   llalalal"  );
    		System.out.println(sb  );
    		
    		String fileName = multipartFile.getOriginalFilename();
    		String contentType = multipartFile.getContentType();
    		String url = sb.toString();
    	//	String description = multipartFile.get
    		
    		
    		FileDto fileDto = new FileDto(fileName,url,contentType);
    		System.out.println(fileDto);
    		
    		System.out.println("Hello inside if");
			try {
			PostedContent obj = mapper.mapDtoToEntity(fileDto, user);
			postRepo.save(obj);
			
			}
			catch (Exception e)
			{
				System.out.println("Error");
			}
			return "file uploaded , path saved in db";
    		
    		}
    		else
    		{
    			return "invalid user" ;
    		}
    		
    		
    		  		

    		
            /*
            InputStream inputStream = new ClassPathResource(gcpConfigFile).getInputStream();

            StorageOptions options = StorageOptions.newBuilder().setProjectId(gcpProjectId)
                    .setCredentials(GoogleCredentials.fromStream(inputStream)).build();

            Storage storage = options.getService();
            Bucket bucket = storage.get(gcpBucketId,Storage.BucketGetOption.fields());

            RandomString id = new RandomString(6, ThreadLocalRandom.current());
            Blob blob = bucket.create(gcpDirectoryName + "/" + fileName + "-" + id.nextString() + checkFileExtension(fileName), fileData, contentType);

            if(blob != null){
                LOGGER.debug("File successfully uploaded to GCS");
                return new FileDto(blob.getName(), blob.getMediaLink()); 
                */ 
            }catch (IOException e){
            LOGGER.error("An error occurred while uploading data. Exception: ", e);
            
            return null;
            
        }
		
        
    }

}
