import { SalePage } from "types";

type Props = {
    page: SalePage,
    onPageChange: Function
  }

function Pagination({ page, onPageChange}: Props) {
    return (
        <div className="row d-flex justify-content-center">
            <nav>
                <ul className="pagination">
                    <li className={`page-item ${page.first?'disabled':''}`}>
                    <button className="page-link" onClick={() => onPageChange(page.number - 1)}>Anterior</button>
                    </li>
                    <li className="page-item">
                        <span className="page-link">{page.number}</span>
                    </li>
                    <li className={`page-item ${page.last?'disabled':''}`}>
                    <button className="page-link" onClick={() => onPageChange(page.number + 1)}>Próxima</button>
                    </li>
                </ul>
            </nav>
        </div>
    )
}

export default Pagination;