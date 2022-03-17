package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.lineup.LineupName;
import seedu.address.model.tag.Tag;
import seedu.address.model.team.TeamName;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Age age;
    private final Height height;
    private final JerseyNumber jerseyNumber;
    private final Set<Tag> tags = new HashSet<>();
    private final Weight weight;
    private TeamName teamName;
    private List<LineupName> lineUpName;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Age age,
                  Height height, JerseyNumber jerseyNumber, Set<Tag> tags, Weight weight) {
        requireAllNonNull(name, phone, email, age, height, jerseyNumber, tags, weight);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.height = height;
        this.jerseyNumber = jerseyNumber;
        this.tags.addAll(tags);
        this.weight = weight;
        this.teamName = null;
        this.lineUpName = new ArrayList<>();
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Age getAge() {
        return age;
    }

    public Height getHeight() {
        return height;
    }

    public JerseyNumber getJerseyNumber() {
        return jerseyNumber;
    }

    public Weight getWeight() {
        return weight;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAge().equals(getAge())
                && otherPerson.getHeight().equals(getHeight())
                && otherPerson.getWeight().equals(getWeight())
                && otherPerson.getJerseyNumber().equals(getJerseyNumber())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, age, jerseyNumber, height, tags, weight);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Age: ")
                .append(getAge())
                .append("; Height: ")
                .append(getHeight())
                .append("; Weight: ")
                .append(getWeight())
                .append("; JerseyNumber: ")
                .append(getJerseyNumber());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

}
