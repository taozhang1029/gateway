package com.kingsley.gateway.controller.ticket.req;

import com.kingsley.common.enums.TicketType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ZhangTao
 * @date 2022/9/25
 * @desc
 */
@Data
public class LeftTicketReqForm {

    /**
     * 车票日期，格式 yyyy-MM-dd
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date trainDate;

    /**
     * 出发车站（车站的电码信息编号，如 北京：BJP）
     */
    private String fromStation;

    /**
     * 到达车站（车站的电码信息编号， 如 长沙：CSQ）
     */
    private String toStation;

    /**
     * 车票类型（成人票、学生票）
     *
     * @see com.kingsley.common.enums.TicketType#code
     */
    private String ticketType = TicketType.ADULT.getCode();

}
