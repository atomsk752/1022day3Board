package org.atomsk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.atomsk.domain.BoardVO;
import org.atomsk.domain.PageParam;

public interface BoardMapper {
	
	
	public int searchCount(PageParam pageParam);
	
	@Update("update tbl_board set title = #{title}, content = #{content} where bno = #{bno}")
	public int update(BoardVO board);


	public List<BoardVO> getList(PageParam param);
	
	@Select("select * from tbl_board where bno = #{bno}")
	public BoardVO get(PageParam param);
	
	@Insert(" insert into tbl_board (title, content, writer) " + 
			"values (#{title} , #{content}, #{writer})")
	public int insert(BoardVO board);
	
	@Select("select count(*) from tbl_board")
	public int count();
	
	@Delete("delete from tbl_board where bno = #{bno}")
	public int delete(PageParam param);

}
