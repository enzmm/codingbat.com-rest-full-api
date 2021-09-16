package pdp.uz.appcodingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Language;
import pdp.uz.appcodingbat.payload.LanguageDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.repository.LanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    @PostMapping
    public Result addLanguage(@RequestBody Language language) {
        Language language1 = new Language();
        language1.setLanguageName(language.getLanguageName());
        languageRepository.save(language1);
        return new Result("Language", true);
    }

    @DeleteMapping(value = "/api/language/{languageId}")
    public Result deleteLanguage(@PathVariable Integer languageId){
        languageRepository.deleteById(languageId);
        return new Result("delete",true);
    }

    @PutMapping("/api/language/{languageId}")
    public Result editLanguage(@PathVariable Integer languageId , @RequestBody LanguageDto languageDto) {
        Optional<Language> optionalLanguage = languageRepository.findById(languageDto.getLanguageId());
        if (optionalLanguage.isPresent()) {
            Language language1 = optionalLanguage.get();
            language1.setLanguageName(languageDto.getLanguageName());
            languageRepository.save(language1);
        }
        return new Result("edit qilindi", true);
    }

    @GetMapping
    public List<Language> getLanguages()
    {
        return  languageRepository.findAll();
    }
}
