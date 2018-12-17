package readinglist.readinglist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Readinglistrepository extends JpaRepository<Bookreadinglist ,Long> {
List<Bookreadinglist> findByReader(String reader);
}
