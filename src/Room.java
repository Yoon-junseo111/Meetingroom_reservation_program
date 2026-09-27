public class Room {

    // 회의실 번호
    private int id;

    // 회의실 이름
    private String name;

    // 수용 인원
    private int capacity;

    // 생성자
    public Room(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    // 회의실 정보 출력
    public void showInfo() {
        System.out.println(
            id + ". " + name + " (수용 인원: " + capacity + "명)"
        );
    }
}