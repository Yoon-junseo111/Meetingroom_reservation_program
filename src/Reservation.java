
public class Reservation {

    // 예약 번호
    private int id;

    // 예약자 이름
    private String userName;

    // 회의실 번호
    private int roomId;

    // 예약 날짜
    private String date;

    // 예약 시작 시간
    private String startTime;

    // 예약 종료 시간
    private String endTime;

    // 생성자
    public Reservation(
            int id,
            String userName,
            int roomId,
            String date,
            String startTime,
            String endTime) {

        this.id = id;
        this.userName = userName;
        this.roomId = roomId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // 예약 정보 출력
    public void showInfo() {
        System.out.println(
            id + ". 예약자: " + userName
            + " / 회의실: " + roomId
            + " / 날짜: " + date
            + " / 시작 시간: " + startTime
            + " / 종료 시간: " + endTime
        );
    }

    // 예약 번호를 반환하는 메서드
    public int getId() {
        return id;
    }

    // 회의실 번호를 반환하는 메서드
    public int getRoomId() {
        return roomId;
    }

    // 예약 날짜를 반환하는 메서드
    public String getDate() {
        return date;
    }

    // 예약 시작 시간을 반환하는 메서드
    public String getStartTime() {
        return startTime;
    }

    // 예약 종료 시간을 반환하는 메서드
    public String getEndTime() {
        return endTime;
    }
}
