/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package defaultweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import defaultweb.dao.NormalBoardDao;
import defaultweb.vo.NormalBoardDefaultVO;
import defaultweb.vo.NormalBoardVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;


@Service("normalBoardService")
public class NormalBoardServiceImpl extends EgovAbstractServiceImpl implements NomalBoardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NormalBoardServiceImpl.class);

	// TODO mybatis 사용
	@Resource(name="normalBoardDao")
	private NormalBoardDao normalBoardDAO;

	/** ID Generation */
	//@Resource(name = "egovIdGnrService")
	//private EgovIdGnrService egovIdGnrService;

	@Override
	public List<NormalBoardVO> getNolmalBoardTotList() throws Exception
	{
		return normalBoardDAO.getNolmalBoardTotList();
	}

	@Override
	public List<?> selectNormalBoardList(NormalBoardDefaultVO searchVO) throws Exception
	{
		return normalBoardDAO.selectNormalBoardList(searchVO);
	}

	@Override
	public int selectNormalBoardListTotCnt(NormalBoardDefaultVO searchVO) throws Exception
	{
		return normalBoardDAO.selectNormalBoardListTotCnt(searchVO);
	}


}
