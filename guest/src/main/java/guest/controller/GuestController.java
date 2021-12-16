package guest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import guest.service.GuestService;
import guest.vo.GuestDefaultVO;
import guest.vo.GuestVO;

/**
 * @Class Name : GuestController.java
 * @Description : Guest Controller class
 * @Modification Information
 *
 * @author Brian
 * @since 2021-12-03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=GuestVO.class)
public class GuestController {

    @Resource(name = "guestService")
    private GuestService guestService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * guest 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 GuestDefaultVO
	 * @return "/guest/GuestList"
	 * @exception Exception
	 */
    @RequestMapping(value="/guest/GuestList.do")
    public String selectGuestList(@ModelAttribute("searchVO") GuestDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> guestList = guestService.selectGuestList(searchVO);
        model.addAttribute("resultList", guestList);
        
        int totCnt = guestService.selectGuestListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/guest/GuestList";
    } 
    
    @RequestMapping("/guest/addGuestView.do")
    public String addGuestView(
            @ModelAttribute("searchVO") GuestDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("guestVO", new GuestVO());
        return "/guest/GuestRegister";
    }
    
    @RequestMapping("/guest/addGuest.do")
    public String addGuest(
            GuestVO guestVO,
            @ModelAttribute("searchVO") GuestDefaultVO searchVO, SessionStatus status)
            throws Exception {
        guestService.insertGuest(guestVO);
        status.setComplete();
        return "forward:/guest/GuestList.do";
    }
    
    @RequestMapping("/guest/updateGuestView.do")
    public String updateGuestView(
            @RequestParam("idx") int idx ,
            @ModelAttribute("searchVO") GuestDefaultVO searchVO, Model model)
            throws Exception {
        GuestVO guestVO = new GuestVO();
        guestVO.setIdx(idx);        
        // 변수명은 CoC 에 따라 guestVO
        model.addAttribute(selectGuest(guestVO, searchVO));
        return "/guest/GuestRegister";
    }

    @RequestMapping("/guest/selectGuest.do")
    public @ModelAttribute("guestVO")
    GuestVO selectGuest(
            GuestVO guestVO,
            @ModelAttribute("searchVO") GuestDefaultVO searchVO) throws Exception {
        return guestService.selectGuest(guestVO);
    }

    @RequestMapping("/guest/updateGuest.do")
    public String updateGuest(
            GuestVO guestVO,
            @ModelAttribute("searchVO") GuestDefaultVO searchVO, SessionStatus status)
            throws Exception {
        guestService.updateGuest(guestVO);
        status.setComplete();
        return "forward:/guest/GuestList.do";
    }
    
    @RequestMapping("/guest/deleteGuest.do")
    public String deleteGuest(
            GuestVO guestVO,
            @ModelAttribute("searchVO") GuestDefaultVO searchVO, SessionStatus status)
            throws Exception {
        guestService.deleteGuest(guestVO);
        status.setComplete();
        return "forward:/guest/GuestList.do";
    }

}
