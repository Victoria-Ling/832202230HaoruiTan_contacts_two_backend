package ling.victoria.contact.pojo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    private Integer id;
    private String name;
    private String phone;
    private Integer gender;
    private Integer isFavorite;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
