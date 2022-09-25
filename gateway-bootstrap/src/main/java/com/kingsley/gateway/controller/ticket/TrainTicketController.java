package com.kingsley.gateway.controller.ticket;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kingsley.common.domain.Page;
import com.kingsley.common.domain.Result;
import com.kingsley.common.service.ticket.TrainTicketReadProvider;
import com.kingsley.common.service.ticket.req.RouteQueryReqDTO;
import com.kingsley.common.service.ticket.req.TrainStationReqDTO;
import com.kingsley.common.service.ticket.req.TrainTicketReqDTO;
import com.kingsley.common.service.ticket.resp.RouteRespDTO;
import com.kingsley.common.service.ticket.resp.TrainStationDTO;
import com.kingsley.common.service.ticket.resp.TrainTicketRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZhangTao
 * @date 2022/9/25
 * @desc 火车票服务网关
 */
@RestController
@RequestMapping("/gateway/train")
public class TrainTicketController {

    @Reference(timeout = 3000)
    private TrainTicketReadProvider trainTicketReadProvider;

    @GetMapping("/station")
    public Result<Page<TrainStationDTO>> queryStations(TrainStationReqDTO reqDTO) {
        return trainTicketReadProvider.pageQueryStations(reqDTO);
    }

    @GetMapping("/ticket")
    public Result<TrainTicketRespDTO> queryTickets(TrainTicketReqDTO reqDTO) {
        return trainTicketReadProvider.queryTickets(reqDTO);
    }

    @GetMapping("/routes")
    public Result<List<RouteRespDTO>> queryRoutes(RouteQueryReqDTO reqDTO) {
        return trainTicketReadProvider.queryRouteByTrainNo(reqDTO);
    }

}
