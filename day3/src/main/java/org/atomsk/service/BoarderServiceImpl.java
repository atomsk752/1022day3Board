package org.atomsk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.atomsk.domain.BoardVO;
import org.atomsk.domain.PageParam;
import org.atomsk.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoarderServiceImpl implements BoardService {

	private BoardMapper mapper;

//	@Override
//	public List<Board> getAll() {
//		
//		//return mapper.getListAll();
//		return null;
//	}

	@Override
	public int register(BoardVO board) {

		return mapper.insert(board);
	}

	@Override
	public List<BoardVO> getList(PageParam param) {

		return mapper.getList(param);
	}

	@Override
	public int getTotal() {
		return mapper.count();
	}

	@Override
	public BoardVO get(PageParam param) {
		return mapper.get(param);
	}

	@Override
	public int remove(PageParam param) {
		return mapper.delete(param);
	}

	@Override
	public int modify(BoardVO board) {

		return mapper.update(board);
	}

}
