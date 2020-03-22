package eu.evelin.demo.model;

import com.google.gson.annotations.Expose;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @NonNull
    @Length(min = 2, max = 60)
    private String firstName;

    @Expose
    @NonNull
    @Length(min = 2, max = 60)
    private String lastName;

    @Expose
    @NonNull
    @NotNull
    @Length(min = 3, max = 60)
    @Column(unique = true, nullable = false)
    private String username;

    @NonNull
    @NotNull
    @Length(min = 4, max = 30)
    @Column(unique = true, nullable = false)
    private String password;

    @Expose
    @NonNull
    @NotNull
    private String role="ROLE_USER";

    private boolean active = true;

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private Collection<Post> posts = new ArrayList<Post>();
    @Expose
    private Date created = new Date();
    @Expose
    private Date modified = new Date();


}
