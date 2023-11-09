package ksmart.ks48team01.user.service;

import ksmart.ks48team01.user.mapper.ContentsMapper;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class ContentsService {
    private final ContentsMapper contentsMapper;

    public ContentsService(ContentsMapper contentsMapper) {
        this.contentsMapper = contentsMapper;
    }

    public List<Map<String, Object>> getContentsInfoList() {
        List<Map<String, Object>> contentsInfoList = contentsMapper.getContentsInfoList();

//        for (Map<String, Object> contentsInfo : contentsInfoList) {
//            System.out.println("처음" + contentsInfo);
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            dateFormat.format(contentsInfo.get("contentsSellStartDate"));
//
//            String contentsSellStartDate = dateFormat.format(contentsInfo.get("contentsSellStartDate"));
//            String contentsSellEndDate = dateFormat.format(contentsInfo.get("contentsSellEndDate"));
//            String contentsSellDuration = contentsSellStartDate + '~' + contentsSellEndDate;
//
//
//            contentsInfoList.get(0).put("contentsSellDuration", contentsSellDuration);
//            System.out.println("마지막" + contentsInfo);
//        }
//        System.out.println("마지막 ----- " + contentsInfoList);

        return contentsMapper.getContentsInfoList();
    }
}
