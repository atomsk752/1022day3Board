package org.atomsk.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageParam {

	private static final double PER = 10.0;
	private int page;
	private int display;
	private int start, end, total, bno;
	private boolean prev, next;
	private String scond;
	private String keyword;
	private String[] types;
	private String type;

	private Map<String, String> cond;
	private boolean extend;

	// private String[] types; //3rd

	public PageParam() {
		this.display = 10;
		this.page = 1;
	}

	public void setType(String type) {
		this.type = type;

		if (type == null || type.trim().length() == 0) {
			this.types = null;
			return;
		}

		this.types = type.split("");
	}

	public int getSkip() {
		return (this.page - 1) * 10;
	}

	public void setTotal(int total) {
		this.total = total;

		this.end = (int) (Math.ceil(this.page / PER)) * 10;
		this.start = this.end - 9;

		if ((this.end * 10) >= total) {
			this.end = (int) (Math.ceil(total / 10.0));
			this.next = false;
		} else {
			this.next = true;
		}

		this.prev = this.start != 1;
	}

	public String getLink(String path) {
		return UriComponentsBuilder.fromPath(path).queryParam("bno", this.bno).queryParam("page", this.page)
				.queryParam("type", this.page).queryParam("keyword", this.page).toUriString();
	}

	public static void main(String[] args) {
		PageParam obj = new PageParam();
		obj.setPage(7);
		obj.setBno(123);
		System.out.println(obj.getLink("redirect:/board/read"));
	}
}
