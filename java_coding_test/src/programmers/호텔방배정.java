package programmers;

import java.util.HashMap;
import java.util.Map;

public class 호텔방배정 {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap<Long, Long> roomMap = new HashMap<>();
        int i = 0;
        for (long rn : room_number){
            answer[i] = findRoom(rn, roomMap);
            i++;
        }
        return answer;
    }

    private long findRoom(long roomNubmer, Map<Long, Long> map){
        if (map.get(roomNubmer) == null){
            map.put(roomNubmer, roomNubmer + 1);
            return roomNubmer;
        }
        long empty = findRoom(map.get(roomNubmer), map);
        map.put(roomNubmer, empty + 1); // 해당 방의 다음번 들어갈 수 있는 방 update
        return empty;
    }
}
