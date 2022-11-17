package pe.com.peru.socio.mssociorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.peru.socio.mssociorest.entity.TypeDocument;

@Repository
public interface TypeDocumentRepository extends JpaRepository<TypeDocument,Integer> {
}
