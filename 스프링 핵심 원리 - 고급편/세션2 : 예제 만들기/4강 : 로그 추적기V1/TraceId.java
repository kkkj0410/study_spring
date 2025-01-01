public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level){
        this.id = id;
        this.level = level;
    }

    private String createId() {
        // UUID ex) abwwefwf-3223-sd23-wef32-~~~
        //-> abwwefwf만 사용

        return UUID.randomUUID().toString().substring(0,8);
    }

    private TraceId createNextId(){
        return new TraceId(id, level + 1);
    }

    private TraceId createPreviousId(){
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel(){
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
