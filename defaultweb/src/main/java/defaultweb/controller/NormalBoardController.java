package defaultweb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import defaultweb.service.NomalBoardService;
import defaultweb.vo.NormalBoardDefaultVO;
import defaultweb.vo.NormalBoardVO;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping(value="/normalboard")
public class NormalBoardController
{
	@Resource(name = "normalBoardService")
	private NomalBoardService nomalBoardService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/*
	 * @RequestMapping(value="/normalboardList", method=RequestMethod.GET) public
	 * String normalboardListGet(Model model) throws Exception { List<NormalBoardVO>
	 * vos = nomalBoardService.getNolmalBoardTotList(); model.addAttribute("vos",
	 * vos);
	 * 
	 * return "normalboard/normalboardList"; }
	 */
	
	@RequestMapping(value = "/normalboardList.do")
	public String selectSampleList(@ModelAttribute("searchVO") NormalBoardDefaultVO searchVO, ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		System.out.println(searchVO);
		
		List<?> sampleList = nomalBoardService.selectNormalBoardList(searchVO);
		model.addAttribute("resultList", sampleList);

		int totCnt = nomalBoardService.selectNormalBoardListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "normalboard/normalboardList";
	}
}
