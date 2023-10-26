package io.nuvalence.platform.notification.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity representing an Email format Content.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "emailFormat")
@ToString(exclude = "emailFormat")
@Entity
@Table(name = "email_format_content")
public class EmailFormatContent {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmailFormat emailFormat;

    @Column(name = "email_layout_input")
    private String emailLayoutInput;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localized_string_template_id", referencedColumnName = "id")
    private LocalizedStringTemplate localizedStringTemplate;
}
