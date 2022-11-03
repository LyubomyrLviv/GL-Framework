package model;

import util.Util;

import java.util.List;
import java.util.Objects;

public class Pet {


    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Status status;


    public static Pet getDefaultPet()
    {
        return getDefaultPet(Status.AVAILABLE);
    }
    public static Pet getDefaultPet(Status status)
    {
        final Pet pet = new Pet();
        pet.setId(Util.generateRandomId());
        pet.setCategory(Category.getDefaultCategory());
        pet.setStatus(status);
        pet.setName(Util.generayeRandomName());
        pet.setPhotoUrls(List.of("asd1","asd2"));
        pet.setTags(List.of(Tag.getDefaultTag()));
        return pet;
    }

    public Pet() {}
    public Long getId() {
        return id;
    }
    public Category getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public List<String> getPhotoUrls() {
        return photoUrls;
    }
    public List<Tag> getTags() {
        return tags;
    }
    public Status getStatus() {
        return status;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) && Objects.equals(category, pet.category) && Objects.equals(name, pet.name) && Objects.equals(photoUrls, pet.photoUrls) && Objects.equals(tags, pet.tags) && Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, photoUrls, tags, status);
    }
}
