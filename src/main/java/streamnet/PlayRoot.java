package streamnet;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PlayRoot_table")
public class PlayRoot {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long memberId;
    private String contentsStatus;
    private Long contentsId;

    @PostPersist
    public void onPostPersist(){

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ @PostPersist Called $$$$$$$$$$$$$$$$$$$$$$   " + contentsStatus);

        if(contentsStatus.equals("DELETED")) {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ Contents Stopped $$$$$$$$$$$$$$$$$$$$$$");
            Stopped stopped = new Stopped();
            BeanUtils.copyProperties(this, stopped);
            stopped.publishAfterCommit();
        } else {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ Contents Watched $$$$$$$$$$$$$$$$$$$$$$");
            Watched watched = new Watched();
            BeanUtils.copyProperties(this, watched);
            watched.publishAfterCommit();
        }


    }

    public Long getContentsId() {
        return contentsId;
    }

    public void setContentsId(Long contentsId) {
        this.contentsId = contentsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public String getContentsStatus() {
        return contentsStatus;
    }

    public void setContentsStatus(String contentsStatus) {
        this.contentsStatus = contentsStatus;
    }




}
