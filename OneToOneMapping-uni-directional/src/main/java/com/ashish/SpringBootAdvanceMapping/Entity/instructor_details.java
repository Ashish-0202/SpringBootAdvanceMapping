package com.ashish.SpringBootAdvanceMapping.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructor_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class instructor_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long instructor_id;

    @Column(name = "youtubelink")
    private String youtubeLink;

    @Column(name = "linkedin")
    private String linkedin;

    public instructor_details(String youtubeLink, String linkedin) {
        this.youtubeLink = youtubeLink;
        this.linkedin = linkedin;
    }

    @Override
    public String toString() {
        return "instructor_details{" +
                "instructor_id=" + instructor_id +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", linkedin='" + linkedin + '\'' +
                '}';
    }
}
