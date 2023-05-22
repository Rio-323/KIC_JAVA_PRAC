context('4:Toolbar', () => {
    context('0: Basic', () => {
        test('3: Add/Remove Buttons', () => {
            bela
                .ready('/w2ui/demos/#/toolbar/3')
                .get('#toolbar .w2ui-tb-button')
                .should('have.length', 3)
                .begin('Append')
                    .get('#tb_toolbar_item_append')
                    .click()
                    .get('#toolbar .w2ui-tb-button:eq(3)')
                    .should('contain.text', 'button 0')
                .end()
                .begin('Insert')
                    .get('#tb_toolbar_item_insert')
                    .click()
                    .get('#toolbar .w2ui-tb-button:eq(3)')
                    .should('contain.text', 'button 1')
                .end()
                .begin('Delete')
                    .get('#tb_toolbar_item_delete')
                    .click()
                    .click()
                    .get('#toolbar .w2ui-tb-button')
                    .should('have.length', 3)
                .end()
        })
    })
})