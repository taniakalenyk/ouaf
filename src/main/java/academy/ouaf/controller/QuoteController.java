package academy.ouaf.controller;

import academy.ouaf.dao.QuoteDao;
import academy.ouaf.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/quotes")
public class QuoteController {

    private final QuoteDao quoteDao;

    @Autowired
    public QuoteController(QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }

    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes() {
        List<Quote> quotes = quoteDao.findAll();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Byte id) {
        Optional<Quote> quote = quoteDao.findById(id);
        return quote.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        Quote savedQuote = quoteDao.save(quote);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Byte id, @RequestBody Quote quoteDetails) {
        Optional<Quote> optionalQuote = quoteDao.findById(id);
        if (optionalQuote.isPresent()) {
            Quote quote = optionalQuote.get();

            quote.setQuoteText(quoteDetails.getQuoteText());

            Quote updatedQuote = quoteDao.save(quote);
            return new ResponseEntity<>(updatedQuote, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Byte id) {
        Optional<Quote> quote = quoteDao.findById(id);
        if (quote.isPresent()) {
            quoteDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/daily")
    public ResponseEntity<Quote> getDailyQuote() {
        // Get the current day of the month
        int dayOfMonth = LocalDate.now().getDayOfMonth();

        // Get all quotes
        List<Quote> allQuotes = quoteDao.findAll();

        if (allQuotes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Calculate the index of the quote to return (using modulo to handle days > number of quotes)
        int quoteIndex = (dayOfMonth - 1) % allQuotes.size();

        // Return the quote at the calculated index
        Quote dailyQuote = allQuotes.get(quoteIndex);
        return new ResponseEntity<>(dailyQuote, HttpStatus.OK);
    }
}
