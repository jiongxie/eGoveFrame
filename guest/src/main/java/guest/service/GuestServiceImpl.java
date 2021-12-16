package guest.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import guest.service.GuestService;
import guest.vo.GuestDefaultVO;
import guest.vo.GuestVO;
import guest.dao.GuestMapper;
/**
 * @Class Name : GuestServiceImpl.java
 * @Description : Guest Business Implement class
 * @Modification Information
 *
 * @author Brian
 * @since 2021-12-03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("guestService")
public class GuestServiceImpl extends EgovAbstractServiceImpl implements
        GuestService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(GuestServiceImpl.class);

    @Resource(name="guestMapper")
    private GuestMapper guestDAO;
    
    //@Resource(name="guestDAO")
    //private GuestDAO guestDAO;
    
    /** ID Generation */
    //@Resource(name="{egovGuestIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * guest을 등록한다.
	 * @param vo - 등록할 정보가 담긴 GuestVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertGuest(GuestVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	guestDAO.insertGuest(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * guest을 수정한다.
	 * @param vo - 수정할 정보가 담긴 GuestVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateGuest(GuestVO vo) throws Exception {
        guestDAO.updateGuest(vo);
    }

    /**
	 * guest을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 GuestVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteGuest(GuestVO vo) throws Exception {
        guestDAO.deleteGuest(vo);
    }

    /**
	 * guest을 조회한다.
	 * @param vo - 조회할 정보가 담긴 GuestVO
	 * @return 조회한 guest
	 * @exception Exception
	 */
    public GuestVO selectGuest(GuestVO vo) throws Exception {
        GuestVO resultVO = guestDAO.selectGuest(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * guest 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return guest 목록
	 * @exception Exception
	 */
    public List<?> selectGuestList(GuestDefaultVO searchVO) throws Exception {
        return guestDAO.selectGuestList(searchVO);
    }

    /**
	 * guest 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return guest 총 갯수
	 * @exception
	 */
    public int selectGuestListTotCnt(GuestDefaultVO searchVO) {
		return guestDAO.selectGuestListTotCnt(searchVO);
	}
    
}
