package pdp.uz.appcodingbat.payload;

import lombok.Data;

@Data
public class AnswerDto {
    private Integer taskId;
    private String text;
    private Integer userId;
    private String correct;
    private Integer answerId;
}
