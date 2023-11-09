package ksmart.ks48team01.service;

import ksmart.ks48team01.mapper.ContentsMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentsService {
    private final ContentsMapper contentsMapper;

    public ContentsService(ContentsMapper contentsMapper) {
        this.contentsMapper = contentsMapper;
    }

    public Map<String, Object> getContentsInfoList(int currentPage) {

        //보여줄 컨텐츠의 개수
        int contentsPerPage = 12;

        // 보여줄 행의 시작점
        int startContentsNum = (currentPage - 1) * contentsPerPage;

        // 전체 컨텐츠의 갯수
        double contentsCnt = contentsMapper.getContentsCnt();

        // 마지막페이지 (전체 컨텐츠의 갯수/보여줄 컨텐츠의 갯수) 올림
        int lastPage = (int)Math.ceil(contentsCnt/contentsPerPage);

        // 보여줄 페이지 번호 초기값:1
        int startPageNum = 1;

        // 마지막 페이지 번호 초기값:10
        int endPageNum = (lastPage < 10) ? lastPage : 10;

        List<Map<String, Object>> contentsInfoList = contentsMapper.getContentsInfoList(startContentsNum, contentsPerPage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("contentsInfoList", contentsInfoList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }
}
