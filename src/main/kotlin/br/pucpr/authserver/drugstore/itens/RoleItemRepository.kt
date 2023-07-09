package br.pucpr.authserver.drugstore.itens

import org.springframework.data.jpa.repository.JpaRepository

interface RoleItemRepository: JpaRepository<RoleItem, Long> {
}