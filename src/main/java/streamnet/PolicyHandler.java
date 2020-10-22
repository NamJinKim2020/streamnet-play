package streamnet;

import streamnet.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    PlayRootRepository playRootRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverWatchCounted_ChangeStatus(@Payload WatchCounted watchCounted){

        if(watchCounted.isMe()){
            System.out.println("##### listener ChangeStatus : " + watchCounted.toJson());

            /*
            Optional<PlayRoot> playRootOptional = playRootRepository.findByContentsId(watchCounted.getContentsId());
            PlayRoot playRoot;
            if(playRootOptional.isPresent()) {
                playRoot= playRootOptional.get();
            } else {
                playRoot = new PlayRoot();
            }

            if("SUCCESS".equals(watchCounted.getStatus())){
                playRoot.setContentsStatus("NORMAL");
            }
            else {
                playRoot.setContentsStatus("ABNORMAL");
            }

            playRootRepository.save(playRoot);
             */

        }
    }


}
