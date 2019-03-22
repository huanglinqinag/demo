package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.DisplacementEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IDisplacementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Dome Class:DisplacementController
 * @Author: LJW
 * @Date: 2019/3/19 18:08
 * @Version 1.0
 */
@Api(tags = "汽车排量")
@RestController
@RequestMapping(value = "/Displacement")
public class DisplacementController {
    @Autowired
    IDisplacementService iDisplacementService;

    @ApiOperation(value = "添加一条汽车排量信息", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "displacementId", value = "汽车排量id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "displacementSize", value = "汽车排量大小", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "saveDisplacement", method = RequestMethod.GET)
    public ResponseBean saveDisplacement(DisplacementEntity displacement) {
        DisplacementEntity displacementEntity = iDisplacementService.save(displacement);
        if (null != displacementEntity) {
            return new ResponseBean(200, "成功", displacementEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据汽车排量id进行删除", notes = "需要汽车排量Id")
    @ApiImplicitParam(name = "displacementId", value = "汽车排量Id", required = true, dataType = "Integer")
    @RequestMapping(value = "/deleteAllByDisplacementId", method = RequestMethod.GET)
    public ResponseBean deleteAllByDisplacementId(Integer displacementId) {
        Integer i = iDisplacementService.deleteAllByDisplacementId(displacementId);
        if (null != i) {
            return new ResponseBean(200, "成功", i);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "添加一条汽车排量信息", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "displacementId", value = "汽车排量id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "displacementSize", value = "汽车排量大小", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "saveDisplacement", method = RequestMethod.GET)
    public ResponseBean updateDisplacement(DisplacementEntity displacement) {
        DisplacementEntity displacementEntity = iDisplacementService.update(displacement);
        if (null != displacementEntity) {
            return new ResponseBean(200, "成功", displacementEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询所有汽车排量信息", notes = "需要分页页数和每页显示的数据条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAllByDisplacement", method = RequestMethod.GET)
    public ResponseBean findAllByDisplacement(Integer pageSize, Integer pageNumber, Pageable pageable) {
        pageable = new PageRequest(pageSize, pageNumber);
        Page<DisplacementEntity> displacementEntities = iDisplacementService.findAll(pageable);
        if (null != displacementEntities) {
            return new ResponseBean(200, "成功", displacementEntities);
        } else {
            throw new UnauthorizedException();
        }

    }
}