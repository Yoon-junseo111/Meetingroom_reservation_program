public class Reservation {

    // 예약 번호
    private int id;

    // 예약자 이름
    private String userName;

    // 회의실 번호
    private int roomId;

    // 예약 날짜
    private String date;

    // 생성자
    public Reservation(int id, String userName, int roomId, String date) {
        this.id = id;
        this.userName = userName;
        this.roomId = roomId;
        this.date = date;
    }

    // 예약 정보 출력
    public void showInfo() {
        System.out.println(
            id + ". 예약자: " + userName
            + " / 회의실: " + roomId
            + " / 날짜: " + date
        );
    }

    // 예약 번호를 반환하는 메서드
    public int getId() {
        return id;
    }
}