package Repository;

import Entity.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
    List<DailyReport> findBySimulationId(Long simulationId);
}
