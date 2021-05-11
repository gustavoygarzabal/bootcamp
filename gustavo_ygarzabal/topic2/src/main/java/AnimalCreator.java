import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.enums.Gender;

public abstract class AnimalCreator {
    public abstract Animal createAnimal(Gender gender);
}
