package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private Hero hero;
    private HeroRepository heroRepository;
    private Collection<Hero> heroes;

    @Before
    public void setUp() throws Exception {
        heroRepository = new HeroRepository();
        hero = new Hero("Hero", 100);
        this.createHeroes();
    }


    private void createHeroes() {
        this.heroes = new ArrayList<>();
        heroes.add(new Hero("Hero1", 80));
        heroes.add(new Hero("Hero2", 100));
        heroes.add(new Hero("Hero3", 180));
        heroes.add(new Hero("Hero4", 280));
        heroes.add(hero);
    }


    private void fillRepository() {
        for (Hero hero : heroes) {
            heroRepository.create(hero);
        }
    }

    @Test
    public void getCount() {
        fillRepository();
        int count = heroRepository.getCount();
        Assert.assertEquals(5,count);
    }

    @Test(expected = NullPointerException.class)
    public void create_throw_if_hero_is_null() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_throw_if_hero_exist() {
        fillRepository();
        heroRepository.create(hero);
    }

    @Test
    public void create_return_correct_message() {
        String actual = heroRepository.create(hero);
        String expected = "Successfully added hero Hero with level 100";
        assertEquals(expected,actual);
    }

    @Test(expected = NullPointerException.class)
    public void remove_throw_if_hero_is_null() {
        fillRepository();
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void remove_throw_if_hero_is_empty_name() {
        fillRepository();
        heroRepository.remove(" ");
    }

    @Test
    public void remove_throw_if_hero_is_present() {
        fillRepository();
        boolean expected = heroes.removeIf(h -> h.getName().equals("Hero"));
        boolean actual = heroRepository.remove("Hero");
        assertEquals(expected,actual);
    }
    @Test
    public void getHeroWithHighestLevel() {
        fillRepository();
        List<Hero> expectedList = heroes.stream().sorted(Comparator.comparing(Hero::getLevel).reversed())
                .limit(1)
                .collect(Collectors.toList());
        Hero expected = expectedList.get(0);
        Hero actual = heroRepository.getHeroWithHighestLevel();
        assertEquals(expected,actual);
    }

    @Test
    public void getHero() {
        fillRepository();
        Hero expected = heroes.stream()
                .filter(h -> h.getName().equals("Hero1"))
                .findFirst()
                .orElse(null);
        Hero actual = heroRepository.getHero("Hero1");
        assertEquals(expected,actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getHeroes_return_Unmodifiable_collection() {
        heroRepository.getHeroes().clear();
    }
}