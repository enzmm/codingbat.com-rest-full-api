package pdp.uz.appcodingbat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
  //  private Integer taskId;
//    private Integer userId;
    private String correct;

    @ManyToOne
    private User users;

    @ManyToOne
    private Task task;
}
