package com.company.woobin_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.company.woobin_board.dao.BDao;
import com.company.woobin_board.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		 
		BDao dao = new BDao();
		ArrayList<BDto>dtos=dao.list();
		model.addAttribute("list",dtos);
	}

}
