package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper dao;
	@Override
	public List<HashMap> getBoardList() {
		// TODO Auto-generated method stub
		return dao.getBoardList();
	}

}
