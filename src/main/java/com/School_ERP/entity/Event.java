package com.School_ERP.entity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Schema(description = "Entity representing an Event in the system")
public class Event {
    @Id
    @Schema(description = "Unique identifier of the admin", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull()
    @Schema(description = "Title of the event title", example = "title")
    private String title;

    @Column
    @NotNull()
    @Schema(description = "description of the event description", example = "description")
    private String description;

    private String picture;

    private long createTimeStamp;
    private long modifiedTimeStamp;
}
