package readinglist.readinglist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
@Controller

@RequestMapping("/")
public class Readinglistcontroller {
private Readinglistrepository readingListRepository;
@Autowired
public Readinglistcontroller(Readinglistrepository readingListRepository) 
{
this.readingListRepository = readingListRepository;
}

@RequestMapping(value="/{reader}", method=RequestMethod.GET)
public String readersBooks(@PathVariable("reader") String reader,Model model) {
List<Bookreadinglist> readingList =readingListRepository.findByReader(reader);
if (readingList != null) {
model.addAttribute("books", readingList);
}
return "readingList";
}

@RequestMapping(value="/{reader}", method=RequestMethod.POST)
public String addToReadingList(
@PathVariable("reader") String reader, Bookreadinglist book) {
book.setReader(reader);
readingListRepository.save(book);
return "redirect:/{reader}";
}
}

