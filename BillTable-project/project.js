document.addEventListener('DOMContentLoaded', () => {
    const tableBody = document.getElementById('tableBody');
    const fetchButton = document.getElementById('fetchButton');



    fetchButton.addEventListener('click', () => {
        fetch('http://localhost:9098/api/bills/output')
            .then(response => 
                {
                if (!response.ok) 
                    {
                    throw new Error('Network response was not ok: ' + response.statusText);
                }
                console.log(response);
                return response.json();
            })
            .then(data => 
                {
                tableBody.innerHTML = ''; // Clear previous data
                if (data.length === 0) 
                    {
                    tableBody.innerHTML = '<tr><td colspan="13">No data available</td></tr>';
                    return;
                }
                data.forEach(bill => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${bill.billId}</td>
                        <td>${bill.billDate}</td>
                        <td>${bill.station}</td>
                        <td>${bill.category}</td>
                        <td>${bill.subcategory}</td>
                        <td>${bill.origin}</td>
                        <td>${bill.manufacturing}</td>
                        <td>${bill.hsnCode}</td>
                        <td>${bill.store}</td>
                        <td>${bill.name}</td>
                        <td>${bill.size}</td>
                        <td>${bill.mrp}</td>
                        <td>${bill.qty}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => {
                console.error('Error fetching data:', error);
                tableBody.innerHTML = '<tr><td colspan="13">Error loading data</td></tr>';
            });
    });
});








