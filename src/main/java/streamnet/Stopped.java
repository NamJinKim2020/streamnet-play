package streamnet;

public class Stopped extends AbstractEvent {

    private Long id;
    private String contentsStatus;
    private Long contentsId;

    public Stopped(){
        super();
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
    public String getContentsStatus() {
        return contentsStatus;
    }

    public void setContentsStatus(String contentsStatus) {
        this.contentsStatus = contentsStatus;
    }
}
