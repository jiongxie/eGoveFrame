package guest.service;

import java.util.List;
import guest.vo.GuestDefaultVO;
import guest.vo.GuestVO;

/**
 * @Class Name : GuestService.java
 * @Description : Guest Business class
 * @Modification Information
 *
 * @author Brian
 * @since 2021-12-03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface GuestService {
	
	/**
	 * guest을 등록한다.
	 * @param vo - 등록할 정보가 담긴 GuestVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertGuest(GuestVO vo) throws Exception;
    
    /**
	 * guest을 수정한다.
	 * @param vo - 수정할 정보가 담긴 GuestVO
	 * @return void형
	 * @exception Exception
	 */
    void updateGuest(GuestVO vo) throws Exception;
    
    /**
	 * guest을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 GuestVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteGuest(GuestVO vo) throws Exception;
    
    /**
	 * guest을 조회한다.
	 * @param vo - 조회할 정보가 담긴 GuestVO
	 * @return 조회한 guest
	 * @exception Exception
	 */
    GuestVO selectGuest(GuestVO vo) throws Exception;
    
    /**
	 * guest 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return guest 목록
	 * @exception Exception
	 */
    List selectGuestList(GuestDefaultVO searchVO) throws Exception;
    
    /**
	 * guest 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return guest 총 갯수
	 * @exception
	 */
    int selectGuestListTotCnt(GuestDefaultVO searchVO);
    
}
