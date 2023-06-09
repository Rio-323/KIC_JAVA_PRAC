export default {
    name        : 'sidebar',
    img         : null,
    topHTML     : '<div style="padding: 10px 5px; border-bottom: 1px solid #aaa;">This is text<input/> <select><option>one</option></select></div>',
    bottomHTML  : '<div style="padding: 10px 5px; border-top: 1px solid #aaa;">Bottom</div>',
    style       : 'border: 1px solid red',
    routeData   : { id: 59, vid: '23.323.4' },
    flatButton: true,
    // flat: true,
    onFlat(event) {
        if (event.goFlat) {
            jQuery('#sidebar').width(50)
        } else {
            jQuery('#sidebar').width(250)
        }
    },
    menu: [
        { id: 1, text: 'Select Item', icon: 'fa fa-star' },
        { id: 2, text: 'View Item', icon: 'fa fa-camera' },
        { id: 4, text: 'Delete Item', icon: 'fa fa-minus' }
    ],
    onMenuClick: function (event) {
        console.log(event);
    },
    onFocus(event) {
        console.log('focus: ', this.name, event);
        // event.preventDefault();
    },
    onBlur(event) {
        console.log('blur: ', this.name, event);
        // event.preventDefault();
    },
    //onKeydown: function (event) { console.log('keyboard', event); event.preventDefault(); },
    nodes: [
        { id: 'top-1', text: 'Top Level 1', icon: 'fa fa-star' },
        { id: 'top-2', text: 'Top Level 2', icon: 'fa fa-star' },
        { id: 'top-3', text: 'Top Level 3', icon: 'fa fa-star',
            nodes: [
                { id: 'top-1-1', text: 'Sub 1', img: 'icon-page' },
                { id: 'top-1-2', text: 'Sub 2', img: 'icon-page' },
                { id: 'top-1-3', text: 'Sub 3', img: 'icon-page',
                    nodes: [
                        { id: 'top-1-3-1', text: 'Sub 3-1', img: 'icon-page' },
                        { id: 'top-1-3-2', text: 'Sub 3-2', img: 'icon-page',
                            nodes: [
                                { id: 'top-1-3-2-1', text: 'Sub 3-1', img: 'icon-page' },
                                { id: 'top-1-3-2-2', text: 'Sub 3-2', img: 'icon-page' },
                            ]
                         }
                    ]
                }
            ]
        },
        { id: 'level-1', text: 'Level 1', expanded: true, group: true,
            nodes: [
                { id: 'level-1-1', text: function () { return  'Level 1.1' }, img1: 'icon-add', icon: 'fa fa-star', count: 1,
                    route: '/project',
                    onClick(event) { console.log('item', event); }
                },
                { id: 'level-1-2', text: 'Level 1.2', img1: 'icon-save', icon: 'fa fa-camera', count: 'some',
                    route: '/project/:id'
                },
                { id: 'level-1-3', text: '<div>Level 2 <input id="check2" tabindex="-1" type="checkbox" style="float:right" onclick="console.log(\'check clicked\')"/></div>', img: 'icon-delete', disabled1: true,
                    route: '/project/:id/view'
                }
            ]
        },
        { id: 'level-2', text: 'Level 2', img: 'icon-folder', expanded: true, group: true,
          nodes: [ { id: 'level-2-1', text: 'Level 2.1', img: 'icon-folder',
                     nodes: [
                       { id: 'level-2-1-1', text: function () { return 'Level 2.1.11' }, img: 'icon-page', count: '4', route: '/some/:id/:vid'},
                       { id: 'level-2-1-2', text: 'Level 2.1.2', img: 'icon-page', count: '10', route: '/some/:id/:vid/ok' },
                       { id: 'level-2-1-3', text: 'Level 2.1.3', img: 'icon-page', count: '22', route: '/some/:id/:vid,:id' },
                       { id: 'level-2-1-4', text: 'Level 2.1.4', img: 'icon-page' },
                       { id: 'level-2-1-5', text: 'Level 2.1.5', img: 'icon-page' },
                       { id: 'level-2-1-6', text: 'Level 2.1.6', img: 'icon-page' },
                       { id: 'level-2-1-7', text: 'Level 2.1.7', img: 'icon-page' },
                       { id: 'level-2-1-8', text: 'Level 2.1.7', img: 'icon-page' },
                       { id: 'level-2-1-9', text: 'Level 2.1.7', img: 'icon-page' },
                       { id: 'level-2-1-10', text: 'Level 2.1.10', img: 'icon-page' },
                       { id: 'level-2-1-11', text: 'Level 2.1.11', img: 'icon-page' },
                       { id: 'level-2-1-12', text: 'Level 2.1.12', img: 'icon-page' },
                       { id: 'level-2-1-13', text: 'Level 2.1.13', img: 'icon-page' },
                       { id: 'level-2-1-14', text: 'Level 2.1.14', img: 'icon-page' },
                       { id: 'level-2-1-15', text: 'Level 2.1.15', img: 'icon-page' }
                 ]},
                   { id: 'level-3-1', text: 'Level 3.1', img: 'icon-folder', expanded: true,
                     nodes: [
                       { id: 'level-3-1-1', text: 'Level 3.1.1', icon: 'fa fa-beer', disabled: true },
                       { id: 'level-3-1-2', text: 'Level 3.1.2', icon: 'fa fa-envelope' },
                       { id: 'level-3-1-3', text: 'Level 3.1.3', icon: 'fa fa-check' },
                       { id: 'level-3-1-4', text: 'Level 3.1.4', icon: 'fa fa-heart' },
                       { id: 'level-3-1-5', text: 'Level 3.1.5', icon: 'fa fa-globe', disabled: true },
                       { id: 'level-3-1-6', text: 'Level 3.1.6', icon: 'fa fa-bars' },
                       { id: 'level-3-1-7', text: 'Level 3.1.7', icon: 'fa fa-user-md' },
                       { id: 'level-3-1-8', text: 'Level 3.1.8', icon: 'fa fa-arrow-circle-o-down' }
                 ]},
                   { id: 'level-4-1', text: 'Level 4.1', img: 'icon-folder',
                     nodes: [
                       { id: 'level-4-1-1', text: 'Level 4.1.1', img: 'icon-page' },
                       { id: 'level-4-1-2', text: 'Level 4.1.2', img: 'icon-page' },
                       { id: 'level-4-1-3', text: 'Level 4.1.3', img: 'icon-page' }
                 ]}
                 ]
        },
        { id: 'level-5', text: 'Level 5', img: 'icon-folder', expanded: true, group: true,
          nodes: [ { id: 'level-5-1', text: 'Level 5.1', img: 'icon-page' },
                   { id: 'level-5-2', text: 'Level 5.2', img: 'icon-page' },
                   { id: 'level-5-3', text: 'Level 5.3', img: 'icon-page' }
                 ]
        }
    ],
    onClick(event) {
        console.log('click', event.target, event);
    }
}