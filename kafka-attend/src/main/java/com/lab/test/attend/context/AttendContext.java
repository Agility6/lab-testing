package com.lab.test.attend.context;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: AttendContext
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/23 20:46
 * @Version: 1.0
 */
@Data
public class AttendContext {

    private String userId;

    private Date attendDate;

}
