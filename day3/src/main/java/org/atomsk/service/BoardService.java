package org.atomsk.service;

import java.util.List;

import org.atomsk.domain.BoardVO;
import org.atomsk.domain.PageParam;

public interface BoardService {
	
	public List<BoardVO> getList(PageParam param);
	
	public int register(BoardVO board);
	
	public int getTotal();
	
	public BoardVO get(PageParam param);
	
	public int remove(PageParam param);
	
	public int modify(BoardVO board);

}
