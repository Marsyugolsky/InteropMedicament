/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('monApp', ['ngRoute', 'ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
        $routeProvider
                .when('/crayons', {
                    controller: "CrayonsController as ctrl",
                    templateUrl: 'listeCrayon.html'
                })
                .when('/crayon/edit/:id', {
                    controller: "CrayonEditController as ctrl",
                    templateUrl: 'editCrayon.html'
                })
                .when('/crayon/new', {
                    controller: "CrayonNewController as ctrl",
                    templateUrl: 'newCrayon.html'
                })
                .when('/boites', {
                    controller: "BoitesController as ctrl",
                    templateUrl: 'listeBoites.html'
                })
                .when('/boite/edit/:id', {
                    controller: "BoiteEditController as ctrl",
                    templateUrl: 'editBoite.html'
                })
                .when('/boite/new', {
                    controller: "BoiteNewController as ctrl",
                    templateUrl: 'newBoite.html'
                })
                .when('/medicament', {
                    controller: "MedicamentController as ctrl",
                    templateUrl: 'listeMedicament.html'
                })
                .when('/medicament/edit/:id', {
                    controller: "MedicamentEditController as ctrl",
                    templateUrl: 'editMedicament.html'
                })
                .when('/medicament/new', {
                    controller: "MedicamentNewController as ctrl",
                    templateUrl: 'newMedicament.html'
                })
                .otherwise({redirectTo: '/crayons'});
    }]);

