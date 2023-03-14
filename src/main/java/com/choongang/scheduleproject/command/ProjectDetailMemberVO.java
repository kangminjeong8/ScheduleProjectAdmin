package com.choongang.scheduleproject.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetailMemberVO {
	
	private String user_id;
	private boolean is_observer;
	private String user_name;
}
