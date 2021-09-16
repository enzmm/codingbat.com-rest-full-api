package pdp.uz.appcodingbat.payload;

import lombok.Data;

@Data
public class TaskDto {
    private String taskName;
    private String taskText;
    private String solution;
    private String hint;
    private String method;
    private Integer languageId;
    private Integer taskId;
}
