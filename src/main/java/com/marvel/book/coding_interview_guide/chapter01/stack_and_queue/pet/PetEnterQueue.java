package com.marvel.book.coding_interview_guide.chapter01.stack_and_queue.pet;

/**
 * 实现一个猫狗队列
 */
public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getType() {
        return this.pet.getPetType();
    }
}
