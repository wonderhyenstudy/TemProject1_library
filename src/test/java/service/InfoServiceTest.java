package service;

import com.library.project.library.dto.LibraryInfoDTO;
import com.library.project.library.dto.LibraryStatsDTO;
import com.library.project.library.service.InfoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Log4j2
public class InfoServiceTest {

    @Autowired
    private InfoService infoService; // 인터페이스 타입으로 주입

    @Test
    @DisplayName("도서관 기본 정보 조회 테스트")
    public void getStaticLibraryInfo_Test() {
        LibraryInfoDTO result = infoService.getStaticLibraryInfo();

        log.info("---------------------------------------");
        log.info("조회 결과: {}", result);
        log.info("도서관명: {}", result.getLibraryName());
        log.info("---------------------------------------");

        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("도서관 통계 데이터 조회 테스트")
    public void getLibraryStatistics_Test() {
        List<LibraryStatsDTO> statsList = infoService.getLibraryStatistics();

        log.info("=======================================");
        statsList.forEach(stat -> log.info("통계 항목: {}", stat));
        log.info("=======================================");

        assertThat(statsList).isNotNull();
    }
}
